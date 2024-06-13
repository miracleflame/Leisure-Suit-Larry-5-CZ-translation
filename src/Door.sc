;;; Sierra Script 1.0 - (do not remove this comment)
(script# 21)
(include sci.sh)
(use Main)
(use PolyPath)
(use Sound)
(use Cycle)
(use PicView)


(class Door of Prop
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		description 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 26505
		lookStr 0
		yStep 2
		view 0
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		palette 0
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		entranceTo 0
		locked 0
		openSnd 40
		closeSnd 41
		state $0000
		doubleDoor 0
		forceOpen 0
		caller 0
		moveToX 0
		moveToY 0
		enterType 2
		exitType 2
		closeScript 0
		openScript 0
	)
	
	(method (init)
		(self approachVerbs: 3)
		(if
		(or forceOpen (and gGNumber (== gGNumber entranceTo)))
			(= state 2)
			(= signal (| signal ignAct))
			(if doubleDoor (doubleDoor ignoreActors: 1))
		)
		(if (== state 0)
			(= cel 0)
			(if doubleDoor (doubleDoor setCel: 0))
		else
			(= cel (- (NumCels self) 1))
			(if doubleDoor (doubleDoor setCel: 255))
		)
		(super init:)
		(if (== state 2)
			(if closeScript
				(self setScript: closeScript)
			else
				(switch enterType
					(0
						(proc0_2)
						(gLarry
							posn: moveToX moveToY
							setMotion: PolyPath approachX approachY self
						)
					)
					(1
						(gLarry
							edgeHit: 0
							posn: approachX approachY
							setHeading: heading
						)
						(self close:)
					)
					(2 (self close:))
				)
			)
		else
			(self stopUpd:)
		)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (== state 2) (self close:) else (self open:))
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(switch state
			(3
				(= state 0)
				(self stopUpd: ignoreActors: 0)
				(if doubleDoor (doubleDoor ignoreActors: 0))
				(if caller (caller cue:))
			)
			(1
				(= state 2)
				(self stopUpd: ignoreActors: 1)
				(if doubleDoor (doubleDoor ignoreActors: 1))
				(if caller (caller cue:))
				(if openScript
					(self setScript: openScript)
				else
					(switch exitType
						(0
							(if (or moveToX moveToY)
								(gLarry
									illegalBits: 0
									setMotion: PolyPath moveToX moveToY self
								)
							)
						)
						(1
							(if (or moveToX moveToY)
								(gLarry setMotion: PolyPath moveToX moveToY self)
							)
						)
						(2 (self cue:))
					)
				)
			)
			(else 
				(cond 
					(
						(and
							(== (gLarry x?) moveToX)
							(== (gLarry y?) moveToY)
						)
						(if entranceTo
							(switch entranceTo
								((global2 north?)
									(gLarry edgeHit: 1)
								)
								((global2 south?)
									(gLarry edgeHit: 3)
								)
								((global2 west?)
									(gLarry edgeHit: 4)
								)
								((global2 east?)
									(gLarry edgeHit: 2)
								)
							)
							(global2 newRoom: entranceTo)
						else
							(self close:)
						)
					)
					(
						(and
							(== (gLarry x?) approachX)
							(== (gLarry y?) approachY)
						)
						(self close:)
					)
				)
				(proc0_3)
			)
		)
	)
	
	(method (open)
		(if locked
			(proc0_14 21 0)
		else
			(proc0_2)
			(= state 1)
			(self setCycle: End self)
			(if openSnd ((Sound new:) number: openSnd play:))
			(if doubleDoor (doubleDoor setCycle: End))
		)
	)
	
	(method (close)
		(= state 3)
		(self setCycle: Beg self)
		(if closeSnd ((Sound new:) number: closeSnd play:))
		(if doubleDoor (doubleDoor setCycle: Beg))
	)
)
