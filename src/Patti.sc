;;; Sierra Script 1.0 - (do not remove this comment)
(script# 24)
(include sci.sh)
(use Main)
(use StopWalk)
(use InvI)
(use User)


(class Patti of Ego
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
		description {Patti}
		sightAngle 180
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 26505
		lookStr 0
		yStep 2
		view 570
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $2000
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
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
		edgeHit 0
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 80])
		(if
		(and (IsObject actions) (actions doit: theVerb param2))
			(return 1)
		)
		(return
			(switch theVerb
				(2 (proc0_14 24 0))
				(5 (proc0_18 gLarry 24 1))
				(3
					(if (proc0_6 35) (proc0_14 24 2) else (proc0_14 24 3))
				)
				(10 (proc0_14 24 4))
				(4
					(switch param2
						(4 (proc0_14 24 5))
						(5 (proc0_14 24 6))
						(8
							(proc0_14 24 7)
							(proc0_18 gLarry 24 8)
						)
						(13
							(if (proc0_6 35)
								(proc0_10 -5)
								(proc0_14 24 9)
								(proc0_8 35)
							else
								(proc0_10 5)
								(proc0_14 24 10)
								(proc0_18 gLarry 24 11)
								(proc0_7 35)
							)
						)
						(else 
							(Format @temp0 24 12 ((Inv at: param2) description?))
							(proc0_14 @temp0)
						)
					)
				)
				(else 
					(super doVerb: theVerb param2 &rest)
				)
			)
		)
	)
	
	(method (get param1 &tmp temp0)
		(= temp0 0)
		(while (< temp0 argc)
			((gInv at: [param1 temp0]) moveTo: 24)
			(++ temp0)
		)
	)
	
	(method (has param1 &tmp temp0)
		(if (= temp0 (gInv at: param1)) (temp0 ownedBy: 24))
	)
	
	(method (normalize param1)
		(= view (if argc param1 else 570))
		(self
			setLoop: -1
			setCel: -1
			setPri: -1
			setMotion: 0
			setCycle: StopWalk -1
			setStep: 3 2
			z: 0
			illegalBits: -32768
			ignoreActors: 0
			moveSpeed: (gGame egoMoveSpeed?)
			cycleSpeed: (gGame egoMoveSpeed?)
		)
	)
	
	(method (setUpInv)
		((ScriptID 19 0) doit: 24)
	)
	
	(method (showInv)
		(if (Inv firstTrue: #ownedBy 24)
			(Inv showSelf: 24)
			(if (not (gIconBar curInvIcon?))
				(gIconBar curIcon: (gIconBar at: 0) disable: 6)
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
			)
		else
			(proc0_14 24 13)
		)
	)
)
