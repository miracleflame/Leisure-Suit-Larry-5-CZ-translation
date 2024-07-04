;;; Sierra Script 1.0 - (do not remove this comment)
(script# 520)
(include sci.sh)
(use Main)
(use LLRoom)
(use Sound)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	rm520 0
)

(local
	local0
	local1
)
(procedure (localproc_0538)
	(Display 520 13 108 local0)
	(Display 520 13 108 local1)
)

(instance rm520 of LLRoom
	(properties
		lookStr {Právì se díváš na exkluzivní èteèku papírových èlenských pásek kavárny "Hard Disk Café". Ta kontroluje, jestli máš povolení vejít dovnitø do klubu.}
		picture 520
	)
	
	(method (init)
		(Load rsSOUND 258)
		(proc0_2)
		(proc0_22 1)
		(super init:)
		(gLarry hide:)
		(switch gGNumber
			(510 (self setScript: sLobby))
			(else  (self setScript: sCafe))
		)
	)
	
	(method (doVerb)
		(self setScript: sTapeout 0 gGNumber)
	)
	
	(method (newRoom newRoomNumber)
		(proc0_22 0)
		(super newRoom: newRoomNumber)
	)
)

(instance sLobby of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (not (gLarry has: 14)) (= state (+ state 2)))
				(= cycles 2)
			)
			(1
				(proc0_14 520 0)
				(tape init: setCycle: End setMotion: MoveTo 313 18 self)
				(sucking play:)
			)
			(2 (= seconds 2))
			(3
				(if (not (gLarry has: 14))
					(Display
						520
						1
						dsCOORD
						75
						60
						dsCOLOR
						global136
						dsWIDTH
						150
						dsFONT
						global23
					)
					(= seconds 5)
				else
					(= local0
						(Display
							520
							2
							dsCOORD
							75
							60
							dsCOLOR
							global136
							dsWIDTH
							150
							dsFONT
							global23
							dsSAVEPIXELS
						)
					)
					(++ state)
					(= seconds 3)
				)
			)
			(4
				(proc0_14 520 3 67 -1 185)
				(global2 newRoom: 510)
			)
			(5
				(proc0_3)
				(switch ((Inv at: 14) state?)
					(1
						(Display
							520
							4
							dsCOORD
							75
							72
							dsCOLOR
							global136
							dsWIDTH
							150
							dsFONT
							global23
						)
					)
					(2
						(Display
							520
							5
							dsCOORD
							75
							72
							dsCOLOR
							global136
							dsWIDTH
							150
							dsFONT
							global23
						)
					)
					(3
						(Display
							520
							6
							dsCOORD
							75
							72
							dsCOLOR
							global136
							dsWIDTH
							150
							dsFONT
							global23
						)
					)
				)
				(= seconds 5)
			)
			(6
				(global2 setScript: sTapeout 0 510)
			)
		)
	)
)

(instance sCafe of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(proc0_14 520 0)
				(tape init: setCycle: End setMotion: MoveTo 313 18 self)
				(sucking play:)
			)
			(2 (= seconds 2))
			(3
				(= local0
					(Display
						520
						2
						dsCOORD
						75
						60
						dsCOLOR
						global136
						dsWIDTH
						150
						dsFONT
						global23
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(4
				(switch ((Inv at: 14) state?)
					(1
						(= local1
							(Display
								520
								7
								dsCOORD
								75
								72
								dsCOLOR
								global136
								dsWIDTH
								150
								dsFONT
								global23
								dsSAVEPIXELS
							)
						)
						(= register 1)
					)
					(2
						(proc0_3)
						(proc0_10 8 111)
						(Display
							520
							8
							dsCOORD
							75
							72
							dsCOLOR
							global136
							dsWIDTH
							150
							dsFONT
							global23
						)
					)
					(3
						(proc0_3)
						(proc0_10 12 111)
						(Display
							520
							9
							dsCOORD
							75
							72
							dsCOLOR
							global136
							dsWIDTH
							150
							dsFONT
							global23
						)
					)
				)
				(= seconds 5)
			)
			(5
				(if register
					(localproc_0538)
					(Display
						520
						10
						dsCOORD
						75
						72
						dsCOLOR
						global136
						dsWIDTH
						150
						dsFONT
						global23
					)
					(proc0_3)
					(= seconds 6)
				else
					(= cycles 1)
				)
			)
			(6
				(global2 setScript: sTapeout 0 525)
			)
		)
	)
)

(instance sTapeout of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
				(and (> ((Inv at: 14) state?) 1) (== gGNumber 525))
					(proc0_14 520 11)
					(proc0_14 520 12)
					((Inv at: 14) state: 4)
					(gLarry put: 14 0)
					(= cycles 1)
				else
					(sucking play:)
					(tape setCycle: Beg setMotion: MoveTo 302 55 self)
				)
			)
			(1 (global2 newRoom: register))
		)
	)
)

(instance tape of Actor
	(properties
		x 302
		y 55
		description {tvoje páska}
		sightAngle 90
		lookStr {Tvoje èlenská páska visí od ústí pøístroje.}
		view 520
		signal $7810
		cycleSpeed 20
	)
)

(instance sucking of Sound
	(properties
		number 258
	)
)
