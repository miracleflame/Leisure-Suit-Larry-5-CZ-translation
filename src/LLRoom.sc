;;; Sierra Script 1.0 - (do not remove this comment)
(script# 18)
(include sci.sh)
(use Main)
(use Class_255_0)
(use PolyPath)
(use Game)
(use InvI)
(use User)
(use Obj)

(public
	eRS 0
)

(local
	[local0 7] = [160 64 108 260 19 146]
)
(procedure (localproc_049c)
	(cond 
		((< (gLarry x?) 0) (gLarry x: (+ 0 (* (gLarry xStep?) 2))))
		((> (gLarry x?) 319) (gLarry x: (- 319 (* (gLarry xStep?) 2))))
	)
)

(procedure (localproc_04e9)
	(cond 
		((< (gLarry y?) (global2 horizon?))
			(gLarry
				y: (+ (global2 horizon?) (* (gLarry yStep?) 2))
			)
		)
		((> (gLarry y?) 189) (gLarry y: (- 189 (* (gLarry yStep?) 2))))
	)
)

(instance controls of Controls
	(properties)
)

(class LLRoom of Rm
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
		lookStr 0
		picture 0
		style $ffff
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY -30000
		obstacles 0
	)
	
	(method (init &tmp temp0 temp1 temp2 temp3)
		(= number gNumber)
		(= controls controls)
		(if (== ((Inv at: 1) owner?) global2)
			(= temp2 0)
			(while (!= [local0 temp2] 0)
				(if (== [local0 temp2] gNumber)
					(if (== ((Inv at: 0) owner?) (Inv at: 1))
						(= temp3 4)
					else
						(= temp3 3)
					)
					((ScriptID 22 3)
						x: [local0 (++ temp2)]
						y: [local0 (++ temp2)]
						setLoop: temp3
						init:
						approachVerbs: 2 3 4
					)
					(break)
				)
				(= temp2 (+ temp2 3))
			)
		)
		(= gPicAngle picAngle)
		(if picture (self drawPic: picture))
		(cond 
			((not (gCast contains: gLarry)) 0)
			(script 0)
			((not ((User alterEgo?) edgeHit?)) 0)
			((proc999_5 style 11 12 13 14)
				(= temp0
					(+
						1
						(/
							(CelWide
								((User alterEgo?) view?)
								((User alterEgo?) loop?)
								((User alterEgo?) cel?)
							)
							2
						)
					)
				)
				(= temp1
					(+
						1
						(/
							(CelHigh
								((User alterEgo?) view?)
								((User alterEgo?) loop?)
								((User alterEgo?) cel?)
							)
							2
						)
					)
				)
				(switch ((User alterEgo?) edgeHit?)
					(1 ((User alterEgo?) y: 188))
					(4
						((User alterEgo?) x: (- 319 temp0))
					)
					(3
						((User alterEgo?) y: (+ horizon temp1))
					)
					(2
						((User alterEgo?) x: (+ 0 temp0))
					)
				)
				((User alterEgo?) edgeHit: 0)
			)
			(else (self setScript: eRS 0 gGNumber))
		)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script (script doit:))
			((not (gCast contains: gLarry)) 0)
			(
				(= temp0
					(switch ((User alterEgo?) edgeHit?)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self setScript: lRS 0 temp0)
			)
		)
	)
	
	(method (doVerb theVerb &tmp [temp0 200])
		(return
			(if (and (== theVerb 2) lookStr)
				(Format @temp0 18 0 lookStr)
				(proc0_14 @temp0)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance lRS of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc0_2)
				(= temp1
					(CelWide (gLarry view?) (gLarry loop?) (gLarry cel?))
				)
				(= temp0
					(CelHigh (gLarry view?) (gLarry loop?) (gLarry cel?))
				)
				(switch register
					((client north?)
						(global2 newRoom: register)
					)
					((client south?)
						(gLarry
							setMotion: PolyPath (gLarry x?) (+ 189 temp0) self
						)
					)
					((client east?)
						(gLarry
							setMotion: PolyPath (+ 319 temp1) (gLarry y?) self
						)
					)
					((client west?)
						(gLarry
							setMotion: PolyPath (- 0 temp1) (gLarry y?) self
						)
					)
				)
			)
			(1 (gLarry hide:) (= cycles 2))
			(2
				(global2 setScript: 0 newRoom: register)
			)
		)
	)
)

(instance eRS of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 0)
				(proc0_2)
				(= temp0
					(CelHigh (gLarry view?) (gLarry loop?) (gLarry cel?))
				)
				(= temp1
					(CelWide (gLarry view?) (gLarry loop?) (gLarry cel?))
				)
				(switch register
					((client north?)
						(localproc_049c)
						(gLarry y: (+ (global2 horizon?) (gLarry yStep?)))
						(= cycles 1)
					)
					((client south?)
						(localproc_049c)
						(gLarry
							y: (+ 189 temp0)
							setMotion: PolyPath (gLarry x?) (- 189 (* (gLarry yStep?) 2)) self
						)
					)
					((client east?)
						(localproc_04e9)
						(gLarry
							x: (+ 319 (/ temp1 2))
							setMotion: PolyPath (- 319 (* (gLarry xStep?) 2)) (gLarry y?) self
						)
					)
					((client west?)
						(localproc_04e9)
						(gLarry
							x: (- 0 (/ temp1 2))
							setMotion: PolyPath (+ 0 (* (gLarry xStep?) 2)) (gLarry y?) self
						)
					)
					(else  (= cycles 1))
				)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)
